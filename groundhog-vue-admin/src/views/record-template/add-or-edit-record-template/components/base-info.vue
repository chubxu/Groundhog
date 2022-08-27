<template>
  <a-form ref="formRef" :model="formData" class="form" :label-col-props="{ span: 6 }" :wrapper-col-props="{ span: 18 }">
    <a-form-item field="recordTemplateName" :label="$t('record.template.step.label.recordTemplateName')" :rules="[
      {
        required: true,
        message: $t('record.template.step.error.recordTemplateName.required'),
      },
      // {
      //   match: /^[a-zA-Z0-9\u4e00-\u9fa5]{1,20}$/,
      //   message: $t('stepForm.form.error.activityName.pattern'),
      // },
    ]">
      <a-input v-model="formData.recordTemplateName" :placeholder="$t('record.template.step.label.placeholder.recordTemplateName')" />
    </a-form-item>
    <a-form-item field="recordTemplateDescription" :label="$t('record.template.step.label.recordTemplateDescripton')" :rules="[
      {
        required: true,
        message: $t('record.template.step.error.recordTemplateDescripton.required'),
      },
    ]">
      <a-input v-model="formData.recordTemplateDescription" :placeholder="$t('record.template.step.label.placeholder.recordTemplateDescripton')" />
    </a-form-item>
    <a-form-item field="recordTime" :label="$t('record.template.step.label.recordTime')" :rules="[
      {
        required: true,
        message: $t('record.template.step.error.recordTime.required'),
      },
    ]">
      <a-input v-model="formData.recordTime" :placeholder="$t('record.template.step.label.placeholder.recordTime')" />
    </a-form-item>
    <a-form-item>
      <a-button type="primary" @click="onNextClick">
        {{ $t('stepForm.button.next') }}
      </a-button>
    </a-form-item>
  </a-form>
</template>

<script lang="ts" setup>
import { ref } from 'vue';
import { FormInstance } from '@arco-design/web-vue/es/form';
import { BaseInfoModel } from '@/api/form';

const emits = defineEmits(['changeStep']);
const formRef = ref<FormInstance>();
const formData = ref<BaseInfoModel>({
  recordTemplateName: '',
  recordTemplateDescription: '',
  recordTime: '',
});

const onNextClick = async () => {
  const res = await formRef.value?.validate();
  if (!res) {
    emits('changeStep', 'forward', { ...formData.value });
  }
};
</script>

<style scoped lang="less">
.container {
  padding: 20px;

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
  width: 500px;
}

.form-content {
  padding: 8px 50px 0 30px;
}
</style>
