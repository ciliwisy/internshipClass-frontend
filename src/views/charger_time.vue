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
    const apiRes = await axios.get('http://localhost:8080/chargerTime');
    console.log(apiRes.data);
    dataList.value = apiRes.data;
    initEcharts();
}

function initEcharts(){

    const xList = dataList.value.map(v => v.stationId);
    const yList = dataList.value.map(v => v.time);
    chartInstance = echarts.init(chartDom.value);
    const option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                data: xList,
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: 'Direct',
                type: 'bar',
                barWidth: '60%',
                data: yList,
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
    <div ref="chartDom" style="width: 1200px;height: 800px"></div>
</template>

<style scoped>

</style>
