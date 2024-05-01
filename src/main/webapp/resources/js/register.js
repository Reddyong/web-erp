function goRegister() {
    let title = document.getElementById("title").value;
    let price = parseInt(document.getElementById("price").value);
    let author = document.getElementById("author").value;
    let page = parseInt(document.getElementById("page").value);

    let formData = {
        title: title,
        price: price,
        author: author,
        page: page
    };

    fetch("http://localhost:8081/web-erp/api/books", {
        method: "POST",
        headers: {"Content-Type" : "application/json"},
        body: JSON.stringify(formData)
    })
        .then(function (response){
            if (!response.ok) {
                throw new Error("error not ok");
            }

            location.href = "/web-erp/restlist";
        })
        .catch(function (error) {
            console.log("error : ", error);
        });
}