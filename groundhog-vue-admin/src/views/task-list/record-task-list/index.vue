<template>
  <div class="container">
    <Breadcrumb :items="['task.list', 'record.task.list']" />
    <a-card class="general-card" :title="$t('record.task.list')">
      <!-- <a-row style="margin-bottom: 16px">
        <a-col :span="16">
          <a-space>
            <a-button type="primary" @click="handleAddClick">
              <template #icon>
                <icon-plus />
              </template>
              {{ $t('searchTable.operation.create') }}
            </a-button>
          </a-space>
        </a-col>
      </a-row> -->
      <a-table row-key="id" :loading="loading" :pagination="pagination" :data="renderData" :bordered="false" @page-change="onPageChange">
        <template #columns>
          <a-table-column :title="$t('recordTaskList.column.taskId')" data-index="number"/>
          <!-- <a-table-column :title="$t('recordTaskList.column.taskName')" data-index="name"/> -->
          <a-table-column :title="$t('recordTaskList.column.taskDescription')" data-index="desc"/>
          <a-table-column :title="$t('recordTaskList.column.taskType')" data-index="type"/>
          <a-table-column :title="$t('recordTaskList.column.createdTime')" data-index="createdTime"/>
          <a-table-column :title="$t('recordTaskList.column.updateTime')" data-index="updatedTime"/>
          <a-table-column :title="$t('recordTaskList.column.createdUser')" data-index="createdUser"/>
          <a-table-column :title="$t('recordTaskList.column.updateUser')" data-index="updatedUser"/>
          <a-table-column :title="$t('recordTaskList.columns.operations')" data-index="operations">
            <template #cell>
              <a-col :span="16">
                <a-space>
                  <!-- <a-button v-permission="['admin']" type="outline" size="small" @click="handleEditClick">
                    {{ $t('templateLists.columns.operations.edit') }}
                  </a-button> -->
                  <a-button v-permission="['admin']" type="outline" size="small" @click="handleRecordClick">
                    {{ $t('recordTaskList.columns.operations.reRecord') }}
                  </a-button>
                </a-space>
              </a-col>
            </template>
          </a-table-column>
        </template>
      </a-table>
    </a-card>

    <!-- 新增录制任务弹出框 -->
    <a-modal v-model:visible="recordModalVisible" :title="$t('templateLists.recordModal.add.title')" 
             @before-ok="handleBeforeOk" @cancel="handleCancel" title-align="start" width="40%" :mask-closable="false">
      <a-form ref="formRef" :model="form" layout="vertical">
        <a-form-item field="name" :label="$t('templateLists.recordModal.recordTaskDescription')" :rules="[
          {
            required: true,
            message: $t('templateLists.recordModal.recordTaskDescription.required'),
          }
        ]">
          <a-input v-model="form.name" />
        </a-form-item>      
        <a-row :gutter="16">
          <a-col :span="12">
            <a-form-item field="name" :label="$t('templateLists.recordModal.recordMachineIp')" :rules="[
              {
                required: true,
                message: $t('templateLists.recordModal.recordMachineIp.required'),
              }
            ]">
              <a-input v-model="form.name" />
            </a-form-item>
          </a-col>
          <a-col :span="12">
            <a-form-item field="name" :label="$t('templateLists.recordModal.recordMachinePort')" :rules="[
              {
                required: true,
                message: $t('templateLists.recordModal.recordMachinePort.required'),
              }
            ]">
              <a-input v-model="form.name" />
            </a-form-item>
          </a-col>
        </a-row>
        <a-row :gutter="16">
          <a-col :span="12">
            <a-form-item field="name" :label="$t('templateLists.recordModal.recordMachineUser')" :rules="[
              {
                required: true,
                message: $t('templateLists.recordModal.recordMachineUser.required'),
              }
            ]">
              <a-input v-model="form.name" />
            </a-form-item>
          </a-col>
          <a-col :span="12">
            <a-form-item field="name" :label="$t('templateLists.recordModal.recordMachinePassword')" :rules="[
              {
                required: true,
                message: $t('templateLists.recordModal.recordMachinePassword.required'),
              }
            ]">
              <a-input v-model="form.name" />
            </a-form-item>
          </a-col>
        </a-row>
      </a-form>
    </a-modal>
  </div>
</template>

<script lang="ts" setup>
  import { computed, ref, reactive } from 'vue';
  import { useRouter } from 'vue-router';
  import { useI18n } from 'vue-i18n';
  import useLoading from '@/hooks/loading';
  import { queryRecordTemplateList, PolicyRecord, PolicyParams } from '@/api/list';
  import { Pagination } from '@/types/global';
  import type { SelectOptionData } from '@arco-design/web-vue/es/select/interface';
  import { FormInstance } from '@arco-design/web-vue/es/form';

  const generateFormModel = () => {
    return {
      number: '',
      name: '',
      contentType: '',
      filterType: '',
      createdTime: [],
      status: '',
    };
  };
  const router = useRouter()
  const { loading, setLoading } = useLoading(true);
  const { t } = useI18n();
  const renderData = ref<PolicyRecord[]>([]);
  const formModel = ref(generateFormModel());
  const basePagination: Pagination = {
    current: 1,
    pageSize: 20,
  };
  const pagination = reactive({
    ...basePagination,
  });

  // 新增录制模板data
  const recordModalVisible = ref(false);
  const formRef = ref<FormInstance>();
  const form = reactive({
    name: '',
    post: ''
  });

  const contentTypeOptions = computed<SelectOptionData[]>(() => [
    {
      label: t('searchTable.form.contentType.img'),
      value: 'img',
    },
    {
      label: t('searchTable.form.contentType.horizontalVideo'),
      value: 'horizontalVideo',
    },
    {
      label: t('searchTable.form.contentType.verticalVideo'),
      value: 'verticalVideo',
    },
  ]);
  const filterTypeOptions = computed<SelectOptionData[]>(() => [
    {
      label: t('searchTable.form.filterType.artificial'),
      value: 'artificial',
    },
    {
      label: t('searchTable.form.filterType.rules'),
      value: 'rules',
    },
  ]);
  const statusOptions = computed<SelectOptionData[]>(() => [
    {
      label: t('searchTable.form.status.online'),
      value: 'online',
    },
    {
      label: t('searchTable.form.status.offline'),
      value: 'offline',
    },
  ]);
  
  
  const fetchData = async (
    params: PolicyParams = { current: 1, pageSize: 20 }
  ) => {
    setLoading(true);
    try {
      const { data } = await queryRecordTemplateList(params);
      renderData.value = data.list;
      pagination.current = params.current;
      pagination.total = data.total;
    } catch (err) {
      // you can report use errorHandler or other
    } finally {
      setLoading(false);
    }
  };


  const search = () => {
    fetchData({
      ...basePagination,
      ...formModel.value,
    } as unknown as PolicyParams);
  };


  const onPageChange = (current: number) => {
    fetchData({ ...basePagination, current });
  };


  fetchData();


  const reset = () => {
    formModel.value = generateFormModel();
  };


  /**
   * 跳转新增录制模板
   */
  const handleAddClick = () => {
    router.push({
      name: 'AddOrEditRecordTemplate',
      params: { pageType: '0' }
    })
  };
  

  /**
   * 跳转编辑录制模板
   */
  const handleEditClick = () => {
    router.push({
      name: 'AddOrEditRecordTemplate',
      params: { pageType: '1' }
    })
  };


  /**
   * 流量录制弹出框
   */
  const handleRecordClick = () => {
    recordModalVisible.value = true;
  };


  /**
   * 确认新增流量录制任务
   */
  const handleBeforeOk = async (done) => {
    const res = await formRef.value?.validate();
    if (!res) {
      console.log('aaa');
      done();
    } else {
      console.log('bbb')
      done(false);
    }
  };


  /**
   * 流量录制弹出框取消事件
   */
  const handleCancel = () => {
    recordModalVisible.value = false;
  };
</script>

<script lang="ts">
  export default {
    name: 'SearchTable',
  };
</script>

<style scoped lang="less">
  .container {
    padding: 0 20px 20px 20px;
  }
  :deep(.arco-table-th) {
    &:last-child {
      .arco-table-th-item-title {
        margin-left: 16px;
      }
    }
  }
</style>
