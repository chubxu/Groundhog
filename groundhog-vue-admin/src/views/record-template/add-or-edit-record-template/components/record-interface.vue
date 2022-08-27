<template>
  <a-form ref="formRef" :model="formData" class="form" :label-col-props="{ span: 7 }" :wrapper-col-props="{ span: 17 }" :style="{width:'800px'}">
    <a-row :gutter="8">
      <a-col :span="16">
        <a-form-item field="httpInterface" :label="$t('record.template.step.label.http.interface')" :rules="[
          {
            required: true,
            message: $t('record.template.step.label.http.interface.required'),
          },
        ]">
          <a-input v-model="formData.httpInterface" :placeholder="$t('record.template.step.label.placeholder.http.interface')" />
        </a-form-item>
      </a-col>
      <a-col :span="8">
        <a-form-item field="httpInterfaceSampleRate" :label="$t('record.template.step.label.sample.rate')" :rules="[
          {
            required: true,
            message: $t('record.template.step.label.sample.rate.required'),
          },
        ]">
          <a-input v-model="formData.httpInterfaceSampleRate" :placeholder="$t('record.template.step.label.placeholder.sample.rate')" />
        </a-form-item>
      </a-col>
    </a-row>
    <a-row :gutter="8">
      <a-col :span="16">
        <a-form-item field="dubboInterface" :label="$t('record.template.step.label.dubbo.interface')" :rules="[
          {
            required: true,
            message: $t('record.template.step.label.dubbo.interface.required'),
          },
        ]">
          <a-input v-model="formData.dubboInterface" :placeholder="$t('record.template.step.label.placeholder.dubbo.interface')" />
        </a-form-item>
      </a-col>
      <a-col :span="8">
        <a-form-item field="dubboInterfaceSampleRate" :label="$t('record.template.step.label.sample.rate')" :rules="[
          {
            required: true,
            message: $t('record.template.step.label.sample.rate.required'),
          },
        ]">
          <a-input v-model="formData.dubboInterfaceSampleRate" :placeholder="$t('record.template.step.label.placeholder.sample.rate')" />
        </a-form-item>
      </a-col>
    </a-row>
    <a-form-item>
      <!-- <a-button type="primary" @click="onNextClick">
        {{ $t('stepForm.button.next') }}
      </a-button> -->
      <a-space>
        <a-button type="secondary" @click="goPrev">
          {{ $t('stepForm.button.prev') }}
        </a-button>
        <a-button type="primary" @click="onNextClick">
          {{ $t('stepForm.button.next') }}
        </a-button>
      </a-space>
    </a-form-item>
  </a-form>
</template>

<script lang="ts" setup>
import { ref } from 'vue';
import { FormInstance } from '@arco-design/web-vue/es/form';
import { ChannelInfoModel } from '@/api/form';

const emits = defineEmits(['changeStep']);

const formRef = ref<FormInstance>();
const formData = ref<ChannelInfoModel>({
  httpInterface: '',
  httpInterfaceSampleRate: '',
  dubboInterface: '',
  dubboInterfaceSampleRate: '',
});

const onNextClick = async () => {
  const res = await formRef.value?.validate();
  if (!res) {
    emits('changeStep', 'submit', { ...formData.value });
  }
};
const goPrev = () => {
  emits('changeStep', 'backward');
};
</script>

<style scoped lang="less">
.container {
  .keep-margin {
    margin-bottom: 20px;
  }
}

.wrapper {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 64px 0;
  background-color: var(--color-bg-2);
}

.steps {
  margin-bottom: 36px;
}

.form {
  width: 540px;
}

.form-content {
  padding: 8px 50px 0 30px;
}
</style>
