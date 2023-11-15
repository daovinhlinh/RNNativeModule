/**
 * @format
 */

import {AppRegistry} from 'react-native';
import App from './App';
import {name as appName} from './app.json';

type ModuleNameType = {
  showView(): Promise<void>,
  showViewNavigateTo(text?: string): Promise<void>,
};

AppRegistry.registerComponent(appName, () => App);
