function getExchangeRates_v1() {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            updateTable(xmlHttp.responseText);
        }
    };

    xmlHttp.open("GET", "https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e");
    // Jak tenhle request poslu pres javu
    // yavolam tohle
    // poslu do databaze
    xmlHttp.send();
}

function getExchangeRates_v2() {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function() {
        console.log(xmlHttp);
        alert("Odpoved: " + xmlHttp.responseText);
        updateTable(xmlHttp.responseText);
        if (this.readyState == 4 && this.status == 200) {

        }
    };

    xmlHttp.open("GET", "http://localhost:8080/test?usedb=true");
    xmlHttp.send();
}

// window.onscroll = function() {fixedHeader()};

// function fixedHeader() {
    
//     var header = document.getElementById("mainHeader");
//     var offset = header.offsetTop;
//     if (window.pageYOffset > offset) {
//         header.classList.add("sticky");
//     } else {
//         header.classList.remove("sticky");
//     }
// }

function updateTable(arrExchangeRates) {
    var exRatesJSON = JSON.parse(arrExchangeRates);

    var tbl = document.getElementById("exTable");
    var rCount = tbl.rows.length;
    while (--rCount)
        tbl.deleteRow(0);

    // header
    tbl.deleteTHead();
    var thead = tbl.createTHead();
    if (exRatesJSON.length > 0) {
        var exRate = exRatesJSON[0]

        var trh = document.createElement('tr');
        var th = document.createElement('th');
        th.appendChild(document.createTextNode('#'));
        trh.appendChild(th);

        for (var key in exRate) {
            var th = document.createElement('th');
            th.appendChild(document.createTextNode(key));
            trh.appendChild(th);
        }
        thead.appendChild(trh);
    }
    
    // body
    for (var i = 0; i < exRatesJSON.length; i++) {
        var exRate = exRatesJSON[i]
        var trd = tbl.insertRow(1+i);

        var td = document.createElement('td');
        td.appendChild(document.createTextNode(1+i));
        trd.appendChild(td);

        for (var key in exRate) {
            var value = exRate[key];
            var td = document.createElement('td');
            td.appendChild(document.createTextNode(value));
            if (key == 'move') {
                var img = document.createElement('img');
                img.className = 'moveImage';
                var moveDbl = parseFloat(value);
                if (moveDbl > 0.0)
                    img.src = 'https://img.icons8.com/material-sharp/24/26e07f/stairs-up.png';
                else
                    img.src = 'https://img.icons8.com/material-sharp/24/fa314a/stairs-down.png';
                td.appendChild(img);
            }
            trd.appendChild(td);
        }
    }
}