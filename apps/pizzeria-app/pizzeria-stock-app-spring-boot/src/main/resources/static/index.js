/**
 * 
 */
var pizzaTab = [
    {
        nom:"Pépéroni",
        code: "PEP"
    },

    {
        nom:"Margherita",
        code: "MAR"
    }
];

// itérer
pizzaTab.forEach(function(obj){
    // code pour chaque objet
    console.log("NOM=", obj.nom);
});

// filtrer
var pizzaFiltre = pizzaTab.filter(function(obj) {
    return obj.code === "MAR";
});

// transformer
var pizzaTransform = pizzaTab.map(function(obj) {

    return {
        code : obj.code,
        taille : obj.nom.length
    };
});

pizzaTab.filter(function(obj) {
    return obj.code === "MAR";
}).map(function(obj) {
    return {
        code : obj.code,
        taille : obj.nom.length
    };
}).forEach(function(obj){
    console.log("obj = ", obj);
});

$.get("http://localhost:8080/ingredients", function(data){


    console.log(data);

    var htmls = data.map(function(obj) {
        return "<div>"+obj.nom+"</div>";

    });

    $("body").html(htmls);
});