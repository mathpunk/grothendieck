<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
<script src="http://assets.annotateit.org/annotator/v1.2.9/annotator-full.min.js"></script>
<link rel="stylesheet" href="http://assets.annotateit.org/annotator/v1.2.9/annotator.min.css">


Setting up Annotator
Setting up Annotator requires only a single line of code. Use jQuery to select the element that you would like to annotate eg. <div id="content">...</div> and call the .annotator() method on it:

jQuery(function ($) {
    $('#content').annotator();
});
Annotator will now be loaded on the #content element. Select some text to see it in action.










Setting up the default plugins
We include a special setup function in the annotator-full.min.js file that installs all the default plugins for you automatically. To run it just add a call to .annotator("setupPlugins").

jQuery(function ($) {
    $('#content').annotator()
                 .annotator('setupPlugins');
});
This will set up the following:

The Tags, Filter & Unsupported plugins.
The Auth, Permissions and Store plugins, for interaction with the AnnotateIt store.
If the Showdown library has been included on the page the Markdown Plugin will also be loaded.
You can further customise the plugins by providing an object containing options for individual plugins. Or to disable a plugin set it’s attribute to false.

jQuery(function ($) {
    // Customise the default plugin options with the third argument.
    $('#content').annotator()
                 .annotator('setupPlugins', {}, {
                   // Disable the tags plugin
                   Tags: false,
                   // Filter plugin options
                   Filter: {
                     addAnnotationFilter: false, // Turn off default annotation filter
                     filters: [{label: 'Quote', property: 'quote'}] // Add a quote filter
                   }
                 });
});
Adding more plugins
To add a plugin first make sure that you’re loading the script into the page. Then call .annotator('addPlugin', 'PluginName') to load the plugin. Options can also be passed to the plugin as additional parameters after the plugin name.

Here we add the tags plugin to the page:

jQuery(function ($) {
    $('#content').annotator()
                 .annotator('addPlugin', 'Tags');
});
