window.$ = window.jquery = require('./node_modules/jquery');
window.dt = require('./node_modules/datatables.net')();
window.$('#table_id').DataTable();


var $ = require('jquery');
var dt = require('datatables.net')();

$(document).ready(function () {
    $('#table_id').DataTable();
});