;; (def sigils-ancien
;; I had an ill-considered idea about breaking up text into loose pieces using brittle and easily
;; forgotten patterns of symbols. Since some of these were me trying to mean something, I've included the data, although my regexes are
;; probably borked.
;;   [
;;     {:kb-whisper #"{{(.*?)}}" }
;;     {:anon #"<<(.*?)\>>" }
;;     {:th-whisper #"\(\((.*?)\)\)" }
;;     {:page #"\[\[(.*?)\]\]"}
;;     {:prefixed #"[!@#$%^&?](\w+)"}
;;     {:tear #"^---\s*$"}
;;     {:asterism #"^***\s*$"}
;;     {:assoc   #"\s?->\s?"}
;;     {:jump  #"\s?=>\s?"}
;;     {:audition  '#{this|that|the other}  'audition.js}
;;     {:old-hed   #"^=.+=$"}])

;; catch (( )) "Tom whispering."
;; catch {{ }} - "Kellyn whispering."
;; catch ^[ ] "footnote or small or aside"
;; catch [^ ] - "alias for Catch ^[ ]"
;; catch [[ ]] - "pages linked out."

;; Implement as a macro?

(defmacro Catcher
  ([regular-expression]

   )
  ([regular-expression name] ,,,)
  )



;; Or.......................
;; catch (( )) "Tom whispering."
;;  {:tom-whispers []}
;;  o
;;
;; Instead of solving your problem in the most abstract way possible, design it abstractly and then solve
;; it in the most concrete way possible.
