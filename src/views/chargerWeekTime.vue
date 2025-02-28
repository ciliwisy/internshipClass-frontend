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
    const apiRes = await axios.get('http://localhost:8080/chargerWeekTime');
    console.log(apiRes.data);
    dataList.value = apiRes.data;
    
    // 创建星期映射表（确保顺序与图表一致）
    const weekMap = {
        'Sun': 6,
        'Mon': 5,
        'Tue': 4,
        'Wed': 3,
        'Thu': 2,
        'Fri': 1,
        'Sat': 0
    };
    
    // 转换数据格式
    const formattedData = dataList.value.map(item => {
        // 将小时和星期转换为数组索引
        const hour = parseInt(item.hour);
        const weekIndex = weekMap[item.week];
        const duration = parseFloat(item.duration);
        
        // 返回符合热力图要求的格式 [hour, weekIndex, duration]
        return [hour, weekIndex, duration || '-'];
    });
    
    initEcharts(formattedData);
}

function initEcharts(formattedData){
    // 确保chartDom已经挂载
    if (!chartDom.value) return;
    
    // 初始化ECharts实例
    chartInstance = echarts.init(chartDom.value);

    // prettier-ignore
    const hours = [
        '0', '1', '2', '3', '4', '5', '6',
        '7', '8', '9', '10', '11',
        '12', '13', '14', '15', '16', '17',
        '18', '19', '20', '21', '22', '23'
    ];
    // prettier-ignore
    const days = [
        'Saturday', 'Friday', 'Thursday',
        'Wednesday', 'Tuesday', 'Monday', 'Sunday'
    ];

    const option = {
        tooltip: {
            position: 'top'
        },
        grid: {
            height: '50%',
            top: '10%'
        },
        xAxis: {
            type: 'category',
            data: hours,
            splitArea: {
                show: true
            }
        },
        yAxis: {
            type: 'category',
            data: days,
            splitArea: {
                show: true
            }
        },
        visualMap: {
            min: 0,
            max: 10,
            calculable: true,
            orient: 'horizontal',
            left: 'center',
            bottom: '15%'
        },
        series: [
            {
                name: 'Charging Duration',
                type: 'heatmap',
                data: formattedData,
                label: {
                    show: true
                },
                emphasis: {
                    itemStyle: {
                        shadowBlur: 10,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    
    // 设置配置项
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
