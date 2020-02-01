
function getProducts() {
    return fetch("/api/products").then((response) => response.json())
}

function toProductHtmlElement(product) {
    let htmlElement = document.createElement('li')

    let innerHtml = `
            <h2>${product.title}</h2>
            <span>${product.price}</span>
            <button data-product-id=${product.id}>Add me</button>
    `;
    htmlElement.innerHtml = innerHtml.trim()
    return htmlElement
}

function bindButton(element) {
    element.querySelector('button').addEventListener('click', (event) => {
        const productId = e.target.getAttribute()
        console.log()
    })
    return element
}
function main() {
    const productsList = document.querySelector('product-list')

    getProducts().then((products) => {
        products
        .map(toProductHtmlElement)
        .map(bindButton)
        .forEach(productsList.appendChild)
    })
}
main();