<template>
  <div class="container">
    <Breadcrumb :items="['record.template', 'record.template.templateLists', pageType == '0' ? 'record.template.addRecordTemplate' : 'record.template.editRecordTemplate']" />
    <a-spin :loading="loading" style="width: 100%">
      <a-card class="general-card">
        <template #title>
          {{ $t(pageType == '0' ? 'record.template.addRecordTemplate' : 'record.template.editRecordTemplate') }}
        </template>
        <div class="wrapper">
          <a-steps v-model:current="step" style="width: 780px" line-less class="steps">
            <a-step :description="$t('record.template.step.subTitle.baseInfo')">
              {{ $t('record.template.step.title.baseInfo') }}
            </a-step>
            <a-step :description="$t('record.template.step.subTitle.recordInterface')">
              {{ $t('record.template.step.title.recordInterface') }}
            </a-step>
            <a-step :description="$t('record.template.step.subTitle.selectPlugin')">
              {{ $t('record.template.step.title.selectPlugin') }}
            </a-step>
            <a-step>
              {{ $t('record.template.step.label.success') }}
            </a-step>
          </a-steps>
          <keep-alive>
            <BaseInfo v-if="step === 1" @change-step="changeStep" />
            <RecordInterface v-else-if="step === 2" @change-step="changeStep" />
            <Plugin v-else-if="step === 3" @change-step="changeStep" />
            <Success v-else-if="step === 4" @change-step="changeStep" />
          </keep-alive>
        </div>
      </a-card>
    </a-spin>
  </div>
</template>

<script lang="ts" setup>
  import { ref, onMounted } from 'vue';
  import { useRoute } from 'vue-router';
  import useLoading from '@/hooks/loading';
  import {
    submitChannelForm,
    BaseInfoModel,
    ChannelInfoModel,
    UnitChannelModel,
  } from '@/api/form';
  import BaseInfo from './components/base-info.vue';
  import RecordInterface from './components/record-interface.vue';
  import Plugin from './components/plugin.vue';
  import Success from './components/success.vue';

  /**
   * 变量定义
   */
  const route = useRoute();
  const pageType = ref(route.params.pageType);
  const { loading, setLoading } = useLoading(false);
  const step = ref(1);
  const submitModel = ref<UnitChannelModel>({} as UnitChannelModel);
  

  /**
   * mounted生命周期钩子
   */
  onMounted(() => {
    console.log(route)
    if(route.params.pageType === '0') {
      pageType.value = '0'
    } else if (route.params.pageType === '1') {
      pageType.value = '1'
    }
  })


  /**
   * 提交表单，创建录制任务模板
   */
  const submitForm = async () => {
    setLoading(true);
    try {
      await submitChannelForm(submitModel.value); // The mock api default success
      step.value = 4;
      submitModel.value = {} as UnitChannelModel; // init
    } catch (err) {
      // you can report use errorHandler or other
    } finally {
      setLoading(false);
    }
  };


  /**
   * 下一步或者上一步操作
   */
  const changeStep = (
    direction: string | number,
    model: BaseInfoModel | ChannelInfoModel | any
  ) => {
    if (typeof direction === 'number') {
      step.value = direction;
      return;
    }

    if (direction === 'forward' || direction === 'submit') {
      submitModel.value = {
        ...submitModel.value,
        ...model,
      };
      if (direction === 'submit') {
        submitForm();
        return;
      }
      step.value += 1;
    } else if (direction === 'backward') {
      step.value -= 1;
    }
  };
</script>

<script lang="ts">
  export default {
    name: 'Step',
  };
</script>

<style scoped lang="less">
  .container {
    padding: 0 20px 20px 20px;
  }
  .wrapper {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 64px 0;
    background-color: var(--color-bg-2);
    :deep(.arco-form) {
      .arco-form-item {
        &:last-child {
          margin-top: 20px;
        }
      }
    }
  }

  .steps {
    margin-bottom: 76px;
  }
</style>
