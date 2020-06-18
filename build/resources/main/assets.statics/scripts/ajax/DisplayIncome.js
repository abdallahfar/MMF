const data =
{
    fromDate: "01/01/2000",
    toDate:   "01/01/2021"
}

$.ajax({
    url:"/income/display",
    data: data,
    success: function(response)
    {
    }
});