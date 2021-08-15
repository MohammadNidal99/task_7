
async function fetchData() {

    const response = await fetch('http://localhost:8080/hrServices/allCountries');
    const data = await response.json();

    const regionsResponse = await fetch('http://localhost:8080/hrServices/allRegion');
    const regions = await regionsResponse.json();

   
    for(var i = 0; i < data.length; i++){
        var node = document.createElement('li')
        node.classList.add("list-group-item");
        node.classList.add("justify-content-between");
        node.classList.add("align-items-center");
        var span = document.createElement('span')
        span.classList.add("badge")
        span.classList.add("bg-primary")
        span.classList.add("rounded-pill")
        span.classList.add("alignSpan")
        span.appendChild(document.createTextNode(data[i]['id']))
        node.append(span);


        node.appendChild(document.createTextNode(data[i]['name']));
        node.value = data[i]['id'];
        document.querySelector('ol').appendChild(node);

        var deleteButton = document.createElement('button');
        deleteButton.name = data[i]['id'];
        deleteButton.appendChild(document.createTextNode("Delete"));
        deleteButton.classList.add("delete");
        deleteButton.classList.add("btn");
        deleteButton.classList.add("btn-outline-danger");

        deleteButton.onclick = function() {
          const response = fetch('http://localhost:8080/hrServices/deleteCountry?id=' + this.parentElement.innerText.substring(0,2)); 
          this.parentElement.remove();
        } 
        node.append(deleteButton);
    }

    var selector = document.getElementById("regions");

    for(var i = 0; i < regions.length; i++) {
      var option = document.createElement('option')
      option.appendChild(document.createTextNode(regions[i]['name']));
      option.value = regions[i]['id'];
      selector.appendChild(option);
      console.log(regions[i]['name']);
    }


}


  function find() {
    var allSpan = document.getElementById("allSpan");
      var input = document.getElementById("searchBar");
      var filter = input.value.toUpperCase(); // input's value
      var ul = document.getElementById("countryList")
      var li = document.getElementsByTagName("li")
      for(var i = 0; i < li.length; i++) {

          var a = li[i].childNodes[1].textContent.toUpperCase();
          if(filter.length == 0) {
            li[i].style.display = "block";
            allSpan.style.display = "inline";
          }
          else if(a[0] != filter) {
            li[i].style.display = "none";
            allSpan.style.display = "none";
               
          }  


      }

      

  }





