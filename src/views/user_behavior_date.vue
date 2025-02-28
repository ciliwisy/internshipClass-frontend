<script setup>

import {onMounted, ref} from "vue";
import axios from "axios";
import * as echarts from "echarts";

const dataList = ref([]);

// 创建一个响应式引用来保存DOM元素
const chartDom = ref();

// 创建一个对象，保存Echarts实例
let chartInstance = null;

async function initData(){
    const apiRes = await axios.get('http://localhost:8080/userbehaviordate');
    console.log(apiRes.data);
    dataList.value = apiRes.data;
    initEcharts();
}

function initEcharts(){
    // 获取日期列表作为x轴数据
    const xList = dataList.value.dateList;
    
    // 定义四种行为的数据系列
    const series = [
        {
            name: '浏览',
            type: 'bar',
            stack: 'total',
            data: dataList.value.eventCnt[0]
        },
        {
            name: '收藏',
            type: 'bar',
            stack: 'total',
            data: dataList.value.eventCnt[1]
        },
        {
            name: '加⼊购物⻋',
            type: 'bar',
            stack: 'total',
            data: dataList.value.eventCnt[2]
        },
        {
            name: '购买',
            type: 'bar',
            stack: 'total',
            data: dataList.value.eventCnt[3]
        }
    ];

    chartInstance = echarts.init(chartDom.value);
    const option = {
        title: {
            text: '按⽇期统计⾏为数据'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow' // 使用阴影作为指示器
            }
        },
        legend: {
            data: ['浏览', '收藏', '加⼊购物⻋', '购买']
        },
        xAxis: {
            type: 'category',
            data: xList,
            axisLabel: {
                rotate: 45
            }
        },
        yAxis: {
            type: 'value'
        },
        series: series,
        grid: {
            bottom: 100
        }
    };
    
    chartInstance.setOption(option);
}

onMounted(() => {
    initData();
})
</script>

<template>
    <div ref="chartDom" style="width: 800px;height: 500px"></div>
</template>

<style scoped>

</style>
