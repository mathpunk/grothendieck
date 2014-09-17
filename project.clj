(defproject grothendieck "0.1.0-SNAPSHOT"
  :description "Grothendieck defines sites."
  :url "http://code.finite.support/grothendieck"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [bikeshed "0.0.5"]
                 [expectations "2.0.9"]
                 [slamhound "1.5.5"]
                 [garden "1.2.1"]
                 [hiccup "1.0.5"]
                 [markdown-clj "0.9.47"]]
  :main ^:skip-aot grothendieck.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
