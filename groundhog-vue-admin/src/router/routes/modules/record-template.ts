import { DEFAULT_LAYOUT } from '../base';
import { AppRouteRecordRaw } from '../types';

const RECORD_TEMPLATE: AppRouteRecordRaw = {
  path: '/record/template',
  name: 'record-template',
  component: DEFAULT_LAYOUT,
  meta: {
    locale: 'record.template',
    requiresAuth: true,
    icon: 'icon-list',
    order: 2,
  },
  children: [
    {
      path: 'template-lists', // The midline path complies with SEO specifications
      name: 'TemplateLists',
      component: () => import('@/views/record-template/template-list/index.vue'),
      meta: {
        locale: 'record.template.templateLists',
        requiresAuth: true,
        roles: ['*'],
      },
    },
  ],
};

export default RECORD_TEMPLATE;
