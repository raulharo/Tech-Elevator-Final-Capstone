/*
 * https://github.com/vuejs/vue-cli/issues/2978
 * https://webpack.js.org/configuration/output/
 */

const path = require('path');

module.exports = {
  configureWebpack: (config) => {
    if (process.env.NODE_ENV === 'development') {
      config.devtool = 'eval-source-map';

      config.output.devtoolModuleFilenameTemplate = (info) => {
        let resPath = info.resourcePath.split(path.sep).join("/");
        let isVue = resPath.match(/\.vue$/);
        let isGenerated = info.allLoaders;    // This is an empty string for the original source files

        if(isVue && isGenerated){
          return `webpack-generated:///${resPath}?${info.hash}`;
        }

        // Original source files will start with vue-source
        return `vue-source:///${resPath}`;
      };
      
      config.output.devtoolFallbackModuleFilenameTemplate = 'webpack:///[resource-path]?[hash]';
    }
  },
}
