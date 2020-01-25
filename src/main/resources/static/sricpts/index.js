
function getProducts() {
    return fetch("/api/products").then((response) => response.json())
}
function main() {
    const productsListEl$ = document.querySelector('product-list')

    getProducts.then((products) => {
        products
        .map(toHtml)
            .map(toElement)
            .map(initializeAddToBasket)
            .forEach(appendToPortList)
        console.log(products);
    })
    console.log("Hello world")
}
main();