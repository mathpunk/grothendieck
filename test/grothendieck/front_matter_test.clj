(ns grothendieck.front-matter-test
  (:require [grothendieck.static.front-matter :refer :all])
  (:require [expectations :refer [expect in]])
  (:require [clojure.string :as string]))

(def test-dir "/home/thomas/hax0r/grothendieck/test/grothendieck/test-site/content")
(def titled "title are cool.wiki")

; This should have front-matter and a body.
(let [test (str test-dir "/" titled)]
  (expect false? (nil? (:front (with-front-matter test))))
  (expect false? (nil? (:body (with-front-matter test)))))
