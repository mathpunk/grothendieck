(ns grothendieck.nanoformats)

(def markings
  {:links #"\[\[(.+)\]\]"
   :tom-whisper #"\[\[.+\]\]"
   :kellyn-whisper #"\[\[.+\]\]"})

;; See also,
;; ~/writing/wiki/design concepts.wiki
;; and especially that link, because there's something quite inspiring about the twitter nanoformats as viewed
;; the eyes you can borrow from indieweb.

;; But for now, the important thing is to



;; Design means pulling things apart:

;; Intrasite Links

(defn sub-links [text]
  (re-seq (:links markings) text))




;; ## Literate Programming
;; What nanoformats would support LP?
;; Comment strategies, for one. This supposed to show up in some places and not in others.
;; The notions of tangling and weaving could be pulled from previous works.
