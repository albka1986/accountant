<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>jQuery.FilterTable Samples</title>
    <script src="../libs/"></script>
    <script src="/path/to/bindWithDelay.js"></script> <!-- optional -->
    <script src="/path/to/jquery.filtertable.js"></script>
    <style>
        .filter-table .quick {
            margin-left: 0.5em;
            font-size: 0.8em;
            text-decoration: none;
        }

        .fitler-table .quick:hover {
            text-decoration: underline;
        }

        td.alt {
            background-color: #ffc;
            background-color: rgba(255, 255, 0, 0.2);
        }
    </style> <!-- or put the styling in your stylesheet -->
</head>
<body>
<h1>jQuery.FilterTable Samples</h1>
<p>The following are very basic pages which use the <a href="http://sunnywalker.github.com/jQuery.FilterTable">jQuery
    Filter Table Plugin</a>.</p>
<ul>
    <li><a href="filtertable-sample.html">Basic Sample</a></li>
    <li><a href="filtertable-striping.html">Alternate Row Striping</a></li>
    <li><a href="filtertable-quick.html">Quick List Items</a></li>
    <li><a href="filtertable-existing-input.html">Using an Existing Input for Filtering</a></li>
    <li><a href="filtertable-any-term.html">Filter on Any Term</a></li>
    <li><a href="filtertable-all-terms.html">Filter on All Terms</a></li>
    <li><a href="filtertable-ignore-class.html">Ignore a Class</a></li>
    <li><a href="filtertable-ignore-columns.html">Ignore Columns</a></li>
    <li><a href="filtertable-min-rows.html">Minimum Rows on Various Table Sizes</a></li>
    <li><a href="filtertable-min-chars.html">Minimum Characters</a></li>
</ul>
</body>
</html>