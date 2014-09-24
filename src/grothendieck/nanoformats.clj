(ns grothendieck.nanoformats
  (:require [clojure.string :refer [replace]])
  (:require [grothendieck.pages :refer [slug]]))

(def markings
  {:internal-links #"\[\[([\w\s]+)\]\]"
   :external-links #"\[.+\]\((.+)\)"
   :tom-whisper #"\[\[.+\]\]"
   :kellyn-whisper #"\[\[.+\]\]"})

(defn internal-links [text]
  (replace text (:internal-links markings) (str "[$1](" (slug "$1") ")")))


(slug "oh hai")

(internal-links "wow [[links]]")


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
