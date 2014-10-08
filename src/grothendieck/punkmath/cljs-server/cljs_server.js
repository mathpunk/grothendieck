goog.addDependency("base.js", ['goog'], []);
goog.addDependency("../cljs/core.js", ['cljs.core'], ['goog.string', 'goog.object', 'goog.string.StringBuffer', 'goog.array']);
goog.addDependency("../cljs/nodejs.js", ['cljs.nodejs'], ['cljs.core']);
goog.addDependency("../cljs_server/core.js", ['cljs_server.core'], ['cljs.core', 'cljs.nodejs']);