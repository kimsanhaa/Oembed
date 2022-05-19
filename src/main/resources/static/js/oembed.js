
function search(){
    const url = document.getElementById("search").value;
    $.ajax({
        type: 'GET',
        url: "/search",
       data:{"url":url},
        success:function (data){resultHtml(data)}
    })
}
function resultHtml(data){
    var html = "<table>";
    html += "<tr>";
    html += "<th>예시<th>";
    html += "</tr>";
    html += "<tr>";
    html += "<td>"+ data +"<td>";
    html += "</tr>";
    html += "</table>";




}

