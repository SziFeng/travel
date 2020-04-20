<template>
    <div class="sights">
        <f-bar text="景点"></f-bar>
        <div class="title">
            <div class="name myflex2">
                <div class="cell1 myflex1">龙门石窟<span>5A</span></div>
                <div class="cell2">导览</div>
            </div>
            <div class="price myflex1">
                <div class="cell3">门票价格：</div>
                <div class="cell4">120元/人</div>
            </div>
            <div class="time myflex1">
                <div class="cell3">开放时间：</div>
                <div class="cell4">07:00-19:00</div>
            </div>
            <div class="address myflex1">
                <div class="cell3">景点地址：</div>
                <div class="cell4">河南省开封市北大门大街210号</div>
            </div>
        </div>
        <div class="myflex2 bar">
            <div >景点美图</div>
            <div class="myflex2 more">更多<svg class="icon rightIcon" aria-hidden="true"><use xlink:href="#icon-youjian"></use></svg></div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'sights'
}
</script>

<style lang="scss">
.sights{
    .title{
        padding: 5px 10px;
        .name{
            .cell1{
                font-size: 28px;
                font-weight: bold;
                span{
                    background-color: #000000;
                    color: #ffffff;
                    border-radius: 2px;
                    font-size: 12px;
                    margin: 5px;
                    padding:1px 3px;
                }
            }
            .cell2{
                color: #ffffff;
                background-color: skyblue;
                padding: 5px 10px;
                border-radius: 5px;
            }
        }
        .price{
            .cell4{
                color: #ea4d4f;
            }
        }
    }
    .bar{
        padding:5px 10px;
        div{
            &:nth-child(1){
                font-size: 20px;
                font-weight: bold;
            }
            .rightIcon{
                font-size: 10px;
            }
        }
    }
}
</style>
