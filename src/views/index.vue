<template>
    <a-layout style="min-height: 100vh">
        <a-layout-sider v-model:collapsed="collapsed" collapsible>
            <div v-show="!collapsed" class="logo" style="text-align: center;padding: 20px">
                <img src="../assets/logo-dark.9e59017c.png" style="width: 140px;margin-bottom: 10px">.
                <span style="font-size: 23px;color: white;">数据平台</span>
            </div>
            <a-menu :selectedKeys="[route.path]" theme="dark" mode="inline">
                <a-menu-item v-for="item in menuList" :key="item.path" @click="clickMenu(item)">
                    <pie-chart-outlined />
                    <span>{{item.name}}</span>
                </a-menu-item>
            </a-menu>
        </a-layout-sider>
        <a-layout>
            <a-layout-header style="background: #fff; padding: 0" />
            <a-layout-content style="margin: 20px 16px 0;">
                <div :style="{ padding: '24px', background: '#fff', minHeight: '360px' }">
                    <router-view />
                </div>
            </a-layout-content>
            <a-layout-footer style="text-align: center">
                Ant Design ©2018 Created by Ant UED
            </a-layout-footer>
        </a-layout>
    </a-layout>
</template>
<script lang="ts" setup>
import {
    PieChartOutlined,
} from '@ant-design/icons-vue';
import {onMounted, ref} from 'vue';
import {useRoute, useRouter} from "vue-router";
const collapsed = ref(false);

const route = useRoute();
const router = useRouter();
const menuList = [
    {
        name: '用户行为统计',
        path: '/user_behavior'
    },
    {
        name: '用户日期行为统计',
        path: '/user_behavior_date'
    },
    {
        name: '充电桩使用时间',
        path: '/charger_time'
    },
    {
        name: '充电桩每周小时使用时间',
        path: '/charge_week_hour_time'
    },
]

const clickMenu = (item) => {
    router.push({path: item.path})
}

</script>
<style scoped>
</style>
