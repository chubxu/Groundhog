import Mock from 'mockjs';
import qs from 'query-string';
import setupMock, { successResponseWrap } from '@/utils/setup-mock';
import { GetParams } from '@/types/global';

const { Random } = Mock;

const data = Mock.mock({
  'list|10': [
    {
      'id|8': /[A-Z][a-z][-][0-9]/,
      'number|2-3': /[0-9]/,
      'name|4-8': /[A-Z]/,
      'desc|4-8': /[A-Z]/,
      'type|1': ['java', 'cpp', 'golang'],
      'createdTime': Random.datetime(),
      'updatedTime': Random.datetime(),
      'createdUser|4-8': /[A-Z]/,
      'updatedUser|4-8': /[A-Z]/,
    },
  ],
});

setupMock({
  setup() {
    Mock.mock(new RegExp('/api/list/record/template'), (params: GetParams) => {
      const { current = 1, pageSize = 10 } = qs.parseUrl(params.url).query;
      const p = current as number;
      const ps = pageSize as number;
      return successResponseWrap({
        list: data.list.slice((p - 1) * ps, p * ps),
        total: 10,
      });
    });
  },
});
