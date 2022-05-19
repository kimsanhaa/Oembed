
function search(){
    const url = document.getElementById("search").value;
    $.ajax({
        type: 'GET',
        url: "/search",
       data:{"url":url},
        success:function (data){console.log(data)}
    })

}
// function search(){
//     const url = document.getElementById("search").value;
//     $.ajax({
//         type: 'GET',
//         url: "https://\\www.youtube.com/oembed?url=https%3A//youtube.com/watch%3Fv%3DdBD54EZIrZo&format=json",
//         success:function (data){console.log(data)}
//     })
//
// }

