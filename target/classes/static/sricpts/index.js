
function getProducts() {
    return fetch("/api/products").then((response) => response.json())
}
function main() {
    const productsListEl$ = document.querySelector('product-list')

    getProducts.then((products) => {
        console.log(products);
    })
    console.log("Hello world")
}
main();