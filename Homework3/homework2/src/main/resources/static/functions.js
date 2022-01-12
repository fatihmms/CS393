getProducts()

function getProducts() {
    axios.get("/shops/products")
        .then(res => {
            loadTableData(res.data)
        });

}
let productIDs = []
function loadTableData(products){
    const tableBody = document.getElementById('tableData');
    let dataHtml = '';

    for (let index in products) {

        let name = products[index].name;
        let price = products[index].price;
        productIDs.push([products[index].id]);
        dataHtml += '<tr><td class="productName">' + name + '</td><td class="productPrice">' + '$'+ price + '</td>' + '<td><button class="addCart" onclick="addToCartClicked()">Add Cart</button></td></tr>';
    }
    tableBody.innerHTML = dataHtml;
}

function addToCartClicked() {
    let button = event.target;
    let item = button.parentElement.parentElement;
    let title = item.getElementsByClassName("productName")[0].innerText;
    let price = item.getElementsByClassName("productPrice")[0].innerText;
    let id = productIDs[item.sectionRowIndex]
    addCart(title, price, id);
}

let productList = []
let productListPrice = []
let productIDCart = []
function addCart(title, price, id){
    const cartData = document.getElementById("cartData");
    let text = cartData.innerHTML;
    if(productList.includes(title)){
        alert("You added this product to cart! Product quantity is updated");
        let items = document.getElementsByClassName("itemName");
        for (let item in items){
            if(title === items[item].innerHTML){
                let nodes = items[item].parentElement.childNodes;
                let quantity = nodes[2].innerHTML;
                quantity = parseInt(quantity);
                nodes[2].innerHTML = quantity + 1;
                text = cartData.innerHTML;
            }
        }
    }else {
        productList.push(title);
        productListPrice.push(price);
        productIDCart.push(parseInt(id));
        text += '<tr><td class="itemName">'+ title + '</td><td class="itemPrice">'+  price +'</td><td class="quantity">'+ 1 +'</td><td><input id="selectItem" type="checkbox" size="10px"></td></tr>';
    }
    cartData.innerHTML = text;
    updateTotalAmount(productListPrice);
}

function createOrder(){
    let sum = 0;
    if(productList.length === 0){
        alert("Please add a product to cart")
    }
    else {
        let text  = document.getElementById("totalAmount").innerHTML.split("$");
        sum = parseInt(text[1]);
        axios.post("/shops/order", {
            amount: sum,
            products: productIDCart
        })
        productList = []
        productListPrice = []
        updateTotalAmount(productListPrice)
        document.getElementById("cartData").innerHTML = '';
        alert("Your order is created")
    }
}

function updateTotalAmount(prices){
    const quantities = document.getElementById("cartData").getElementsByClassName("quantity");
    let sum = 0;
    if(prices === null){
        sum = 0;
    }else{
        for(let i = 0; i < prices.length; i++){
            let price = parseInt(prices[i].replace("$",""));
            let quantity = parseInt(quantities[i].innerHTML);
            let totalPrice = price * quantity;
            sum += totalPrice;
        }
    }
    let totalAmount = document.getElementById("totalAmount")
    totalAmount.innerHTML = "Total amount is: $" + sum
}

function removeSelectedItems(){
    const cb = document.querySelectorAll('#selectItem')

    if(cb.length === 0){
        alert("Please select a product");
    }
    else{
        for(let i = 0; i < cb.length; i++){
            if(cb[i].checked) {
                cb[i].parentElement.parentElement.remove();

                productList.splice(i,1);
                productListPrice.splice(i,1);

            }
        }
    }
    updateTotalAmount(productListPrice);
}
