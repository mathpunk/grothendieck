(ns grothendieck.nanoformats-test
  (:require [grothendieck.literate.nanoformats :refer :all])
  (:use expectations))




























;; This is just bad.
;; =======================================================================
;; Creating standard markdown links out of vimwiki shortcuts.
;; =======================================================================
;;
;; Singles.
;; (expect "This has a [link](link.html)." (internal-links "This has a [[link]]."))

;; (expect "This has no link." (internal-links "This has no link."))

;; ;; Multiples.
;; (expect "I'm text with [one link](one-link.html) and also [another link](another-link.html)."
;;         (internal-links "I'm text with [[one link]] and also [[another link]]."))
