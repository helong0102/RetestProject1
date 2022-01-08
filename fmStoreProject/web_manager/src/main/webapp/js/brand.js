new Vue({
    el:"#app",
    data:{
        brandList:[],
        brand:{}
    },
    methods:{
        findAllBrand:function () {
            var _this = this;
            axios.get("/brand/getAllBrands.do").then(function (response) {
                console.log(response.data)
                _this.brandList = response.data;
            }).catch(function (reason) {
                console.log(reason)
            })
        }
    },
    created:function () {
        this.findAllBrand();
    }

});