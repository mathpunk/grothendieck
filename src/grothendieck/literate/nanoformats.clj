(ns grothendieck.literate.nanoformats
  (:require [clojure.string :as string])
  (:require [grothendieck.static.pages :refer [slug]]))

(def markings
  {:internal-links #"\[\[(.+)\]\]"
   :external-links #"\[.+\]\((.+)\)"
   :tom-whisper #"\[\[.+\]\]"
   :kellyn-whisper #"\[\[.+\]\]"})

(defn internal-links
  [text]
  (string/replace text #"\[\[(.+)\]\]"
                  (fn [[full-match first-group]]
                    (str "[" first-group "](" (slug first-group) ")"))))




;; Later:
;(defn external-links [text]
  ;(re-seq (:external-links markings) text))
;(external-links "This links [out](http://example.com)")

;; See also,
;; ~/writing/wiki/design concepts.wiki
;; and especially that link, because there's something quite inspiring about the twitter nanoformats as viewed
;; the eyes you can borrow from indieweb.

;; But for now, the important thing is to



;; Design means pulling things apart:

;; Intrasite Links

; (defn sub-links [text]
;  (re-seq (:links markings) text))




;; ## Literate Programming
;; What nanoformats would support LP?
;; Comment strategies, for one. This supposed to show up in some places and not in others.
;; The notions of tangling and weaving could be pulled from previous works.
ns nanoformats

defprotocol Nanoformat
  regex
  part1, or caption
  part2, or data
  (html [n] "What md/html does the thing compile to?
             Whenever possible, let pandoc do the work."
        default: just return the text, jerk.
        )
  (notify [n] "Is a function that does something cool when a data value is null, and someone
              asks it to."
        default: mail or exo brain Tom's devices or email account)
