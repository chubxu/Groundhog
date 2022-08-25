<template>
  <div class="container">
    <Breadcrumb :items="['record.template', 'record.template.templateLists']" />
    <a-card class="general-card" :title="$t('record.template.templateLists')">
      <!-- <a-row>
        <a-col :flex="1">
          <a-form
            :model="formModel"
            :label-col-props="{ span: 6 }"
            :wrapper-col-props="{ span: 18 }"
            label-align="left"
          >
            <a-row :gutter="16">
              <a-col :span="8">
                <a-form-item
                  field="number"
                  :label="$t('searchTable.form.number')"
                >
                  <a-input
                    v-model="formModel.number"
                    :placeholder="$t('searchTable.form.number.placeholder')"
                  />
                </a-form-item>
              </a-col>
              <a-col :span="8">
                <a-form-item field="name" :label="$t('searchTable.form.name')">
                  <a-input
                    v-model="formModel.name"
                    :placeholder="$t('searchTable.form.name.placeholder')"
                  />
                </a-form-item>
              </a-col>
              <a-col :span="8">
                <a-form-item
                  field="contentType"
                  :label="$t('searchTable.form.contentType')"
                >
                  <a-select
                    v-model="formModel.contentType"
                    :options="contentTypeOptions"
                    :placeholder="$t('searchTable.form.selectDefault')"
                  />
                </a-form-item>
              </a-col>
              <a-col :span="8">
                <a-form-item
                  field="filterType"
                  :label="$t('searchTable.form.filterType')"
                >
                  <a-select
                    v-model="formModel.filterType"
                    :options="filterTypeOptions"
                    :placeholder="$t('searchTable.form.selectDefault')"
                  />
                </a-form-item>
              </a-col>
              <a-col :span="8">
                <a-form-item
                  field="createdTime"
                  :label="$t('searchTable.form.createdTime')"
                >
                  <a-range-picker
                    v-model="formModel.createdTime"
                    style="width: 100%"
                  />
                </a-form-item>
              </a-col>
              <a-col :span="8">
                <a-form-item
                  field="status"
                  :label="$t('searchTable.form.status')"
                >
                  <a-select
                    v-model="formModel.status"
                    :options="statusOptions"
                    :placeholder="$t('searchTable.form.selectDefault')"
                  />
                </a-form-item>
              </a-col>
            </a-row>
          </a-form>
        </a-col>
        <a-divider style="height: 84px" direction="vertical" />
        <a-col :flex="'86px'" style="text-align: right">
          <a-space direction="vertical" :size="18">
            <a-button type="primary" @click="search">
              <template #icon>
                <icon-search />
              </template>
              {{ $t('searchTable.form.search') }}
            </a-button>
            <a-button @click="reset">
              <template #icon>
                <icon-refresh />
              </template>
              {{ $t('searchTable.form.reset') }}
            </a-button>
          </a-space>
        </a-col>
      </a-row>
      <a-divider style="margin-top: 0" /> -->
      <a-row style="margin-bottom: 16px">
        <a-col :span="16">
          <a-space>
            <a-button type="primary" @click="handleAddClick">
              <template #icon>
                <icon-plus />
              </template>
              {{ $t('searchTable.operation.create') }}
            </a-button>
            <!-- <a-upload action="/">
              <template #upload-button>
                <a-button>
                  {{ $t('searchTable.operation.import') }}
                </a-button>
              </template>
            </a-upload> -->
          </a-space>
        </a-col>
        <!-- <a-col :span="8" style="text-align: right">
          <a-button>
            <template #icon>
              <icon-download />
            </template>
            {{ $t('searchTable.operation.download') }}
          </a-button>
        </a-col> -->
      </a-row>
      <a-table row-key="id" :loading="loading" :pagination="pagination" :data="renderData" :bordered="false" @page-change="onPageChange">
        <template #columns>
          <a-table-column :title="$t('templateLists.column.templateId')" data-index="number"/>
          <a-table-column :title="$t('templateLists.column.templateName')" data-index="name"/>
          <a-table-column :title="$t('templateLists.column.templateDescription')" data-index="desc"/>
          <a-table-column :title="$t('templateLists.column.templateType')" data-index="type"/>
          <a-table-column :title="$t('templateLists.column.createdTime')" data-index="createdTime"/>
          <a-table-column :title="$t('templateLists.column.updateTime')" data-index="updatedTime"/>
          <a-table-column :title="$t('templateLists.column.createdUser')" data-index="createdUser"/>
          <a-table-column :title="$t('templateLists.column.updateUser')" data-index="updatedUser"/>
          <a-table-column :title="$t('templateLists.columns.operations')" data-index="operations">
            <template #cell>
              <a-col :span="16">
                <a-space>
                  <a-button v-permission="['admin']" type="outline" size="small" @click="handleEditClick">
                    {{ $t('templateLists.columns.operations.edit') }}
                  </a-button>
                  <a-button v-permission="['admin']" type="outline" size="small">
                    {{ $t('templateLists.columns.operations.record') }}
                  </a-button>
                </a-space>
              </a-col>
            </template>
          </a-table-column>
        </template>
      </a-table>
    </a-card>

    <!-- 新增录制模板弹出框 -->
    <a-modal v-model:visible="recordTemplateModalVisible" :title="addOrEditRecordTemplate ? $t('templateLists.recordTemplateModal.add.title') : $t('templateLists.recordTemplateModal.edit.title')" 
             @cancel="handleCancel" title-align="start" width="80%">
      <a-form :model="form">
        <a-form-item field="name" :label="$t('templateLists.recordTemplateModal.templateName')">
          <a-input v-model="form.name" />
        </a-form-item>
        <a-form-item field="name" :label="$t('templateLists.recordTemplateModal.templateDescription')">
          <a-input v-model="form.name" />
        </a-form-item>
        <a-form-item field="post" label="Post">
          <a-select v-model="form.post">
            <a-option value="post1">Post1</a-option>
            <a-option value="post2">Post2</a-option>
            <a-option value="post3">Post3</a-option>
            <a-option value="post4">Post4</a-option>
          </a-select>
        </a-form-item>
      </a-form>
    </a-modal>
  </div>
</template>

<script lang="ts" setup>
  import { computed, ref, reactive } from 'vue';
  import { useI18n } from 'vue-i18n';
  import useLoading from '@/hooks/loading';
  import { queryRecordTemplateList, PolicyRecord, PolicyParams } from '@/api/list';
  import { Pagination } from '@/types/global';
  import type { SelectOptionData } from '@arco-design/web-vue/es/select/interface';

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
  const recordTemplateModalVisible = ref(false);
  const addOrEditRecordTemplate = ref(true);
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
  const handleAddClick = () => {
    addOrEditRecordTemplate.value = true;
    recordTemplateModalVisible.value = true;
  };
  const handleCancel = () => {
    recordTemplateModalVisible.value = false;
  };
  const handleEditClick = () => {
    addOrEditRecordTemplate.value = false;
    recordTemplateModalVisible.value = true;
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
