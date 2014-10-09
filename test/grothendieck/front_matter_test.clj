(ns grothendieck.front-matter-test
  (:require [grothendieck.static.front-matter :refer :all])
  (:require [expectations :refer [expect in]])
  (:require [clojure.string :as string]))

(def test-dir "/home/thomas/hax0r/grothendieck/test/grothendieck/test-site/content")

; This should have front-matter and a body.
(let [test (str test-dir "/" "title are cool.wiki")]
  (expect false? (nil? (:front (with-front-matter test))))
  (expect false? (nil? (:body (with-front-matter test))))
  (expect {:title "some title"} (in (:front (with-front-matter test))))
  (expect #"if-let statement in core" (:body (with-front-matter test)))
  )

; This has body, but no front matter.
(let [test (str test-dir "/" "links are important.wiki")
      result (with-front-matter test)]
  (expect #"hypertext dammit" (:body result))
 ; (expect true? (nil? (:front result)))
  )

; I expected the :front of that to be nil. Troubling. Let's test the processor.
(let [test (str test-dir "/" "links are important.wiki")
      result (process-file test)]
  (expect #"hypertext dammit" (:body result))
  result
  )
