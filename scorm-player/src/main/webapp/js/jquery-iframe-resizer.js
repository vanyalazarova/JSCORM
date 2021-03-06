(function ($) {
    $.fn.iframeAutoHeight = function (options) {
        // set default option values
        var options = $.extend({
            heightOffset: 0
        }, options);

        // iterate over the matched elements passed to the plugin
        $(this).each(function () {
            // Check if browser is Opera or Safari(Webkit so Chrome as well)
            if ($.browser.safari || $.browser.opera) {
                // Start timer when loaded.
                $(this).load(function () {
                    var iframe = this;
                    var delayedResize = function () {
                        resizeHeight(iframe);
                    };
                    setTimeout(delayedResize, 0);
                });

                // Safari and Opera need a kick-start.
                var source = $(this).attr('src');
                $(this).attr('src', '');
                $(this).attr('src', source);
            }
            else {
                // For other browsers.
                $(this).load(function () {
                    resizeHeight(this);
                });
            }

            // resizeHeight
            function resizeHeight(iframe) {
                // Set inline style to equal the body height of the iframed content plus a little
                var newHeight = iframe.contentWindow.document.body.offsetHeight + options.heightOffset;
                if (newHeight == options.heightOffset) // some scorm packages return zero height, so let's hack
                    newHeight = $("#"+iframe.id).contents().height();
                iframe.style.height = newHeight + 'px';
            }

        }); // end
    }
})(jQuery);