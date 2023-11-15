/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import {NavigationContainer} from '@react-navigation/native';
import {createNativeStackNavigator} from '@react-navigation/native-stack';
import React from 'react';
import Home from './src/Home';
import Screen1 from './src/Screen1';
import codePush from 'react-native-code-push';

const Stack = createNativeStackNavigator();
let codePushOptions = {checkFrequency: codePush.CheckFrequency.ON_APP_RESUME};

function App(): JSX.Element {
  // const {FancyNativeModule} = NativeModules;
  // console.log(FancyNativeModule);

  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Home" component={Home} />
        <Stack.Screen name="Screen1" component={Screen1} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default codePush(codePushOptions)(App);
