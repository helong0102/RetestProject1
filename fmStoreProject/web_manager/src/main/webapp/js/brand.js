new Vue({
    el:"#app",
    data:{
        brandList:[],
        brand:{},//定义品牌实体
        page:1, // 当前页码
        pageSize:5, // 一页有多少条数据
        total:150, // 总页码数
        maxPage:9, // 最大页码数
        selectIds:[] // 记录选择了那些记录的id
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
        // 添加/ 更新品牌
        brandSave:function () {
            var _this = this;

             // 区分是保存还是修改
            if (_this.brand.id != null){
                // 更新品牌
                axios.post("/brand/update.do",_this.brand)
                    .then(function (value) {
                        // 刷新页面
                        _this.pageHandler(_this.page);
                        _this.brand = {};
                    })
            }else{
                // 添加品牌
                axios.post("/brand/add.do",_this.brand)
                    .then(function (value) {
                        console.log(value.data);
                        // 刷新页面
                        _this.pageHandler(1);
                        _this.brand = {};
                    })
            }
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
        },
        // 批量删除品牌
        deleteSelection:function(event,id){
            // 复选框选中
            if (event.target.checked){
                // 向数组中添加元素
                this.selectIds.push(id);
            }else {
                // 从数组中移除
                var idx = this.selectIds.indexOf(id);
                this.selectIds.splice(idx,1);
            }
        },
        // 删除按钮
        brandDelete:function () {
            var _this = this;
            // 使用qs插件 处理数组
            axios.post("/brand/delete.do",Qs.stringify({ids:_this.selectIds},{indices:false}))
                .then(function (response) {
                    _this.pageHandler(_this.page);
                    _this.selectIds = [];
                }).catch(function (reason) {
                    alert(reason.message);
            })
        }

    },
    // 创建Vue对象后调用
    created:function () {
        //this.findAllBrand();
        this.pageHandler(1);
    }
});