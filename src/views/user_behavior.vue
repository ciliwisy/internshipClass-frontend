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
    const apiRes = await axios.get('http://localhost:8080/userbehavior');
    console.log(apiRes.data);
    dataList.value = apiRes.data;
    initEcharts();
}

function initEcharts(){

    const xList = dataList.value.map(v => v.name);
    const yList = dataList.value.map(v => v.value);
    chartInstance = echarts.init(chartDom.value);
    const option = {
        xAxis: {
            type: 'category',
            data: xList,
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                data: yList,
                type: 'bar'
            }
        ]
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
