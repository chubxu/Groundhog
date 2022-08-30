import { DEFAULT_LAYOUT } from '../base';
import { AppRouteRecordRaw } from '../types';

const RECORD_TEMPLATE: AppRouteRecordRaw = {
  path: '/task/list',
  name: 'task-list',
  component: DEFAULT_LAYOUT,
  meta: {
    locale: 'task.list',
    requiresAuth: true,
    icon: 'icon-list',
    order: 3,
  },
  children: [
    {
      path: 'record-task-list', // The midline path complies with SEO specifications
      name: 'RecordTaskList',
      component: () => import('@/views/task-list/record-task-list/index.vue'),
      meta: {
        locale: 'record.task.list',
        requiresAuth: true,
        roles: ['*'],
      },
    },
    {
      path: 'replay-task-list', // The midline path complies with SEO specifications
      name: 'ReplayTaskList',
      component: () => import('@/views/task-list/replay-task-list/index.vue'),
      meta: {
        locale: 'replay.task.list',
        requiresAuth: true,
        roles: ['*'],
      },
    },
  ],
};

export default RECORD_TEMPLATE;
