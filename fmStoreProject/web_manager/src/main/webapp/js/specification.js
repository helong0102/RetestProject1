new Vue({
    el:"#app",
    data:{
        specList:[],
        spec:{},// 添加品牌实体
        page:1,// 显示的是那一页
        pageSize:10,// 每一页显示的数据条数
        total:150,// 记录总数
        maxPage:9,//最大页码数
        selectIds:[], // 记录选择了那些记录ID
        secEntity:{
            specOptionList:[],
            specification:{}
        }
    },
    methods:{
        pageHandler:function (page) {
            alert(page);
        },
        // 规格高级分页查询
        pageHandler: function (page) {
            _this = this;
            this.page = page;
            axios.post("/spec/search.do?page="+page+"&rows="+_this.pageSize+"",_this.spec)
                .then(function (response) {
                    //取服务端响应的结果
                    _this.specList = response.data.rows;
                    _this.total = response.data.total;
                    console.log(response);
                }).catch(function (reason) {
                console.log(reason);
            })
        },
        // 新增规格显示
        addRow:function () {
            this.secEntity.specOptionList.push({});
        },
        // 删除规格
        deleteTableRow:function(index){
            this.secEntity.specOptionList.splice(index,1);
        },
        // 保存
        save:function () {
            _this = this;
            axios.post("/spec/add.do",_this.secEntity)
                .then(function (response) {
                    // 刷新页面
                    _this.pageHandler(_this.page);
                    _this.secEntity.specOptionList=[];
                    _this.secEntity.specification={};
                }).catch(function (reason) {
                    console.log(reason)
            })
        }

    },
    created:function () {
        this.pageHandler(1);
    }



});