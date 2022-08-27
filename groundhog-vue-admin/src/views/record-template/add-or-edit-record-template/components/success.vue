<template>
  <div class="success-wrap">
    <a-result status="success" :title="$t('record.template.step.success.title')"/>
    <a-space :size="16">
      <a-button key="view" type="primary" @click="backRecordTemplateList">
        {{ $t('record.template.step.button.back.list') }}
      </a-button>
      <a-button key="again" type="secondary" @click="oneMore">
        {{ $t('record.template.step.button.recreate') }}
      </a-button>
    </a-space>
  </div>
</template>

<script lang="ts" setup>
import { useRouter } from 'vue-router';

const router = useRouter()

const emits = defineEmits(['changeStep']);
const oneMore = () => {
  emits('changeStep', 1);
};
const backRecordTemplateList = () => {
  router.push({
    name: 'TemplateLists'
  })
}
</script>

<style scoped lang="less">
.success-wrap {
  text-align: center;
}

:deep(.arco-result) {
  padding-top: 0;
}

.details-wrapper {
  width: 895px;
  margin-top: 54px;
  padding: 20px;
  text-align: left;
  background-color: var(--color-fill-2);
}
</style>
