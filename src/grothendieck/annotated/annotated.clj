hiccup.page :as page

(page/include-js "list of js sources"
  "http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"
  "http://assets.annotateit.org/annotator/v1.2.9/annotator-full.min.js")

(page/include-css "http://assets.annotateit.org/annotator/v1.2.9/annotator.min.css")

; ## Setting up Annotator

<script>
jQuery(function ($) {
    $('p').annotator();
});
</script>
