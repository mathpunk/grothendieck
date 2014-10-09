hiccup.page :as page

(page/include-js "list of js sources"
  "http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"
  "http://assets.annotateit.org/annotator/v1.2.9/annotator-full.min.js")

(page/include-css "http://assets.annotateit.org/annotator/v1.2.9/annotator.min.css")

; ## Setting up Annotator

; Setting up Annotator requires only a single line of code. 

; Select the element that you would like to annotate eg. <div id="content">...</div> and
; call the .annotator() method on it. In jQuery, 


jQuery(function ($) {
    $('#content').annotator();
});

; Annotator will now be loaded on the #content element. Select some text to see it in action.
