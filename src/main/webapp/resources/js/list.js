function bookList() {
    fetch("http://localhost:8081/web-erp/api/books")
        .then(response => response.json())
        .then(function (books){
            let tbody = document.getElementById("tbody");
            let html = "";
            books.forEach(function (book){
                html += "<tr>";
                html += "<td>" + book.num + "</td>";
                html += "<td>" + book.title + "</td>";
                html += "<td>" + book.price + "</td>";
                html += "<td>" + book.author + "</td>";
                html += "<td>" + book.page + "</td>";
                html += "</tr>";
            });
            tbody.innerHTML = html;
        })
        .catch(function (error){
            console.log("error", error);
        });

    console.log("bookList 호출");
}