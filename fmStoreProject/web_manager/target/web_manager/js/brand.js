new Vue({
    el:"#app",
    data:{
        brandList:[],
        brand:{},//定义品牌实体
        page:1, // 当前页码
        pageSize:5, // 一页有多少条数据
        total:150, // 总页码数
        maxPage:9 // 最大页码数
    },
    methods:{
        // 直接查询所有结果
        /*findAllBrand:function () {
            var _this = this;
            axios.get("/brand/getAllBrands.do").then(function (response) {
                console.log(response.data)
                _this.brandList = response.data;
            }).catch(function (reason) {
                console.log(reason)
            })
        },*/
        pageHandler:function (page) {
            this.page = page;
            alert(this.page);
        },
        // pageHelper分页查询
        pageHandler:function (page) {
            _this = this;
            this.page = page;
            axios.get('/brand/findPage.do',{params:{page:page,pageSize:_this.pageSize}})
                .then(function (response) {
                    // 取服务器响应结果
                    _this.brandList = response.data.rows;
                    _this.total = response.data.total;
                    console.log(response)
                }).catch(function (reason) {
                    console.log(reason)
            })
        },
        // 添加品牌 保存实体
        brandSave:function () {
            var _this = this;
            axios.post("/brand/add.do",_this.brand)
                .then(function (value) {
                console.log(value.data);
                // 刷新页面
                _this.pageHandler(1);
            })
        },
        // 根据品牌Id进行查询
        findById:function (id) {
            _this = this;
            axios.get("/brand/findOne.do",{params:{id:id}})
                .then(function (response) {
                    _this.brand = response.data;
                    console.log(response.data)
                }).catch(function (reason) {
                console.log(reason)
            })
        }

    },
    // 创建Vue对象后调用
    created:function () {
        //this.findAllBrand();
        this.pageHandler(1);
    }


});