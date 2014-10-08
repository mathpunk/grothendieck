(defproject makepager "0.0.1-SNAPSHOT"
  :description "Combines markdown with templates and styles and spits them at a target dir to be shipped."
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [markdown-clj "0.9.47"]
                 [hiccup "1.0.5"]
                 [enlive "1.1.5"]
                 [garden "1.2.1"]]
  :main makepager.core
  :aot [makepager.core]
  :profiles {:dev {:dependencies [[midje "1.5.1"]]}})

