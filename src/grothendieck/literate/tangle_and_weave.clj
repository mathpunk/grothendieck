(ns grothendieck.literate.tangle-and-weave)

(defprotocol LiterateProgram
  (tangle [f & opts] "Produces f in executable form.")
  (weave [f & opts] "Produces f in readable form. Plain text or html options."))
