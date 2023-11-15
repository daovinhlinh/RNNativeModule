import {
  Button,
  StyleSheet,
  Text,
  View,
  NativeModules,
  Alert,
} from 'react-native';
import React, {useEffect, useLayoutEffect} from 'react';
import {useNavigation} from '@react-navigation/native';
import {useCustomHook} from '../hooks/useCustomHook';
import codePush from 'react-native-code-push';
import NetInfo from '@react-native-community/netinfo';
import Crashes from 'appcenter-crashes';

const Component1 = () => {
  useEffect(() => {
    console.log('Component1 mounted');
    return () => console.log('Component1 unmounted');
  }, []);

  useLayoutEffect(() => {
    console.log('Component1 useLayoutEffect mounted');
    return () => console.log('Component1 useLayoutEffect unmounted');
  }, []);

  return (
    <View>
      <Text style={{color: 'red'}}>Component1</Text>
    </View>
  );
};

const {NativeModule} = NativeModules;
const Home = () => {
  const navigation = useNavigation();
  console.log('render home');
  const {state, setState} = useCustomHook(1);

  // useEffect(() => {
  //   console.log('Home mounted');
  //   return () => console.log('Home unmounted');
  // }, []);

  // useLayoutEffect(() => {
  //   console.log('Home useLayoutEffect mounted');
  //   return () => console.log('Component1 useLayoutEffect unmounted');
  // }, []);

  useEffect(() => {
    (async () => {
      const res = await fetch('https://pokeapi.co/api/v2/pokemon/ditto');
      const data = await res.json();
      const enabled = await Crashes.isEnabled();
      console.log(enabled);

      setState(data.species.name);
    })();
  }, []);

  const showView = () => {
    NativeModule.showView();
  };

  const testPerf = () => {
    const start = performance.now();
    for (let i = 0; i < 1000000; i++) {
      [1, 2, 3, 4, 5].reduce((acc, val) => acc + val, 0);
    }
    const end = performance.now();
    console.log(`Time taken: ${end - start} milliseconds`);
  };

  const onButtonPress = () => {
    codePush.sync({
      updateDialog: {
        optionalIgnoreButtonLabel: 'Later',
        optionalInstallButtonLabel: 'Yes',
        optionalUpdateMessage: 'New version available',
        title: 'Do you want to update?',
      },
      installMode: codePush.InstallMode.IMMEDIATE,
    });
  };

  const testPerfNative = async () => {
    console.log(NativeModule.testNativePerf());
    // console.log(res);
  };

  return (
    <View style={styles.container}>
      <Text>Home {state}</Text>
      <Button title="Increase" onPress={() => setState(state + 1)} />
      <Button
        title="Go to screen 1"
        onPress={() => {
          navigation.push('Screen1');
        }}
      />
      <Button title="Check update" onPress={onButtonPress} />
      <Button
        title="Test perf"
        onPress={() => {
          Crashes.generateTestCrash();
          throw new Error('This is a test javascript crash!');
        }}
      />
      <Button title="Test perf native" onPress={testPerfNative} />
      <Component1 />
    </View>
  );
};

export default Home;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'red',
  },
});
