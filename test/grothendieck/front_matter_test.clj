(ns grothendieck.front-matter-test
  (:require [grothendieck.front-matter :refer :all])
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
  (expect :body (in (keys result)))
  (expect #"hypertext dammit" (:body result))
  )

; Let's hunt down the join w/o space error.
(let [test (str test-dir "/" "links are important.wiki")
      result (with-front-matter test)]
  (expect #"link should\nbe" (:body result))   ; ????????????/

  )

; I'm sick of this contexting silliness. Let's write a helper.
(defn direct [f]
  (str test-dir "/" f))

; Does process-file do what you think it does? This should have no front-matter.
(expect empty? (:front (process-file (direct "dogfooding.wiki"))))


; ===============================================
; FAIL
; ===============================================
(let [titled (direct "title are cool.wiki")
      bodied (direct "box.wiki")]
  (expect empty? (:front (with-front-matter bodied)))
  )
