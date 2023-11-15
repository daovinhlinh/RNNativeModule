import {Button, StyleSheet, Text, View} from 'react-native';
import React, {useEffect, useLayoutEffect} from 'react';
import {useCustomHook} from '../hooks/useCustomHook';

const Component2 = () => {
  useEffect(() => {
    console.log(' Component2 rerender'); //4
    return () => {
      console.log('Component2 cleanup'); //3
    };
  });

  useLayoutEffect(() => {
    console.log('Component2 useLayoutEffect mounted'); //1
    return () => console.log('Component2 useLayoutEffect unmounted'); //1
  }, []);

  useLayoutEffect(() => {
    console.log('Component2 useLayoutEffect 1 mounted'); //2
    //khi rerender => chayj cleanup r lập tức chạy lại effect
    return () => console.log('Component2 useLayoutEffect 1 unmounted'); //2
  });

  useEffect(() => {
    console.log('Component2 mounted'); //5
    return () => console.log('Component2 unmounted');
  }, []);

  return (
    <View>
      <Text style={{color: 'red'}}>Component2</Text>
    </View>
  );
};

const Screen1 = () => {
  const {state, setState} = useCustomHook(0);

  const [state1, setState1] = React.useState(0);

  useEffect(() => {
    console.log('Screen1 mounted'); //6
    return () => console.log('Screen1 unmounted');
  }, []);

  useEffect(() => {
    console.log('Screen1 state1 update'); //7
    return () => console.log('Screen1 state1 update clean'); //4
  }, [state1]);

  useLayoutEffect(() => {
    console.log('Screen1 useLayoutEffect mounted'); //3 -> vì useLayout sẽ chạy trước khi react vẽ layout ra -> chạy sau khi useLayoutEffect của component2
    return () => console.log('Screen1 useLayoutEffect unmounted');
  }, []);

  return (
    <View>
      <Button title="Screen 1" onPress={() => setState1(state1 + 1)} />
      <Text>Screen1 {state}</Text>

      <Button title="Increase" onPress={() => setState(state + 1)} />

      <Component2 />
    </View>
  );
};

export default Screen1;

const styles = StyleSheet.create({});
